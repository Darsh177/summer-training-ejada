import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div style="max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
      <h2>Login</h2>
      <form (ngSubmit)="onLogin()">
        <div style="margin-bottom: 15px;">
          <label>Username:</label>
          <input type="text" [(ngModel)]="username" name="username" required style="width: 100%; padding: 8px; margin-top: 5px;">
        </div>
        <div style="margin-bottom: 15px;">
          <label>Password:</label>
          <input type="password" [(ngModel)]="password" name="password" required style="width: 100%; padding: 8px; margin-top: 5px;">
        </div>
        <button type="submit" style="padding: 10px 20px; cursor: pointer;">Submit</button>
      </form>
      <p *ngIf="errorMessage" style="color: red; margin-top: 10px;">{{ errorMessage }}</p>
    </div>
  `
})
export class LoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  onLogin() {
    this.authService.login({ username: this.username, password: this.password }).subscribe({
      next: () => this.router.navigate(['/dashboard']),
      error: (err) => this.errorMessage = err.error?.error || 'Invalid credentials'
    });
  }
}
