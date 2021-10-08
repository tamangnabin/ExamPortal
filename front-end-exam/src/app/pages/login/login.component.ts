import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    username: '',
    password: ''
  };

  constructor(private login: LoginService) { }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log('Login button clicked.');

    if (this.loginData.username.trim() == '' && this.loginData.password.trim() == '') {
      Swal.fire('Error', 'Missing fields', 'error');
      return;
    }

    if (this.loginData.username.trim() == '' || this.loginData.username.trim() == null) {
      Swal.fire('Error', 'Username is required', 'error');
      return;
    }

    if (this.loginData.password.trim() == '' || this.loginData.password.trim() == null) {
      Swal.fire('Error', 'Password is required', 'error');
      return;
    }

    //call to the server
    this.login.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log('success');
        console.log(data);

        //save token in local storage on succesfull response
        this.login.loginUser(data.token);

        this.login.getCurrentUser().subscribe(
          (user: any) => {
            this.login.setUser(user);
            console.log(user);

            //redirect if ADMIN : show admin dashboard
            if (this.login.getUserRole() == "ADMIN") {
              window.location.href='/admin-dashboard';
            }
            else if (this.login.getUserRole() == "NORMAL") { //redirect if NORMAL : show normal user dashboard
              window.location.href='/user-dashboard';
            }
            else {
              this.login.logout();
            }

          }
        )

      },
      (error) => {
        console.log('error');
        console.log(error);
        Swal.fire('Error', 'Invalid Details! Try again', 'error');
      }
    )
  }

}
