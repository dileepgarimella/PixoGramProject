import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/User';

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {

  constructor(private userService:UserService) { }
users:User[];
  ngOnInit() {
    this.userService.followers(this.userService.id).subscribe(data=>this.users=data);
  }

}
