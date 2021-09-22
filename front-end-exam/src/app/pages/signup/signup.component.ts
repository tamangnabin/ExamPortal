import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private _snakBar: MatSnackBar) { }

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: ''
  };

  ngOnInit(): void { }

  formSubmit() {
    console.log(this.user);
    if (this.user.username == '' || this.user.username == null) {
      // this._snakBar.open('Username is required !!', '', { duration: 3000 });
      Swal.fire('Missing Field','User name is required','warning');
      return;
    }

    //addUser: userService
    this.userService.addUser(this.user).subscribe(
      (data) => {
        //success
        console.log(data);
        Swal.fire('Success','User is Registered','success');
        //this._snakBar.open('succesfully registered user!!', '', { duration: 3000 });
      },
      (error) => {
        //error
        console.log(error);
        Swal.fire('Error','Something went wrong','error');
        //this._snakBar.open('Something went wrong!!!', '', { duration: 3000 });
      }
    )
  }

}