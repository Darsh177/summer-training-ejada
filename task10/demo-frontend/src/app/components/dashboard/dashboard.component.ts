import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div style="padding: 30px;">
      <h2>Dashboard (Protected Route)</h2>
      <hr>
      <p>Spring Boot API Response: <strong style="color: green;">{{ apiResponse }}</strong></p>
      <br>
      <button (click)="logout()" style="padding: 8px 16px; background-color: #d9534f; color: white; border: none; border-radius: 4px; cursor: pointer;">Logout</button>
    </div>
  `
})
export class DashboardComponent implements OnInit {
  apiResponse = 'Loading...';

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/api/v1/demo-controller', { responseType: 'text' })
      .subscribe({
        next: (data) => this.apiResponse = data,
        error: (err) => this.apiResponse = 'Connection failed or invalid token'
      });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
