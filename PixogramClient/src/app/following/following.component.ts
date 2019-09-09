import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/User';

@Component({
  selector: 'app-following',
  templateUrl: './following.component.html',
  styleUrls: ['./following.component.css']
})
export class FollowingComponent implements OnInit {

  constructor(private userService:UserService) { }
users:User[];

getfollowers()
{
console.log(this.users);
}
  ngOnInit() {
    this.userService.following(this.userService.id).subscribe(data=>{this.users=data});
    this.getfollowers();
  }

}
