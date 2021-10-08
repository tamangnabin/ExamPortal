import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  // generate token
  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/auth`, loginData);
  }

  // loginUser : set token in local storage
  public loginUser(token: string) {
    localStorage.setItem('token', token);
    return true;
  }

  // isLogin : checks if user is logged in or not
  public isLoggedIn() {
    let token = localStorage.getItem("token");
    if (token == undefined || token == '' || token == null) {
      return false;
    } else {
      return true;
    }
  }

  // logout : remove token from the local storage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  // getToken : get's token from the local storage and returs the value
  public getToken(){
    return localStorage.getItem('token');
  } 

  // getCurrentUser : gets the list of the logged in users
  public getCurrentUser(){
    return this.http.get(`${baseUrl}/current-users`);
  }

  // setUser : stores user information in the local storage
  public setUser(user: any){
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(){
    let user = localStorage.getItem('user');
    if(user!= null){
      return JSON.parse(user);
    }else{
      this.logout();
      return null;
    }
  }

  public getUserRole(){
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}
