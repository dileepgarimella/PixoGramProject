import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UploadMediaComponent } from './upload-media/upload-media.component';
import { MyMediaComponent } from './my-media/my-media.component';
import { UploadMMediaComponent } from './upload-mmedia/upload-mmedia.component';
import { MediaDetailComponent } from './media-detail/media-detail.component';
import { NewsFeedComponent } from './news-feed/news-feed.component';
import { BlockedAccountsComponent } from './blocked-accounts/blocked-accounts.component';
import { AccountUpdateComponent } from './account-update/account-update.component';
import { SearchComponent } from './search/search.component';
import { FollowersComponent } from './followers/followers.component';
import { FollowingComponent } from './following/following.component';
import { AuthService } from './auth.service';
import { ImagesComponent } from './images/images.component';
import { VideosComponent } from './videos/videos.component';
import { FollowComponent } from './follow/follow.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DetailsUploadComponent } from './upload/details-upload/details-upload.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { ListUploadComponent } from './upload/list-upload/list-upload.component';
import { UploadFileService } from './upload/upload-file.service';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    UploadMediaComponent,
    MyMediaComponent,
    UploadMMediaComponent,
    MediaDetailComponent,
    NewsFeedComponent,
    BlockedAccountsComponent,
    AccountUpdateComponent,
    SearchComponent,
    FollowersComponent,
    FollowingComponent,
    ImagesComponent,
    VideosComponent,
    FollowComponent,
    DetailsUploadComponent,
    FormUploadComponent,
    ListUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'UploadMedia', component: UploadMediaComponent},
      {path: 'MediaDetail', component: MediaDetailComponent},
      {path: 'UploadMMedia', component: UploadMMediaComponent},
      {path: 'MyMedia', component: MyMediaComponent},
      {path: 'MediaDetail', component: MyMediaComponent},
      {path: 'Follow', component: FollowComponent},
      {path: 'Followers', component: FollowersComponent},
      {path: 'Following', component: FollowingComponent},
      {path: 'Login', component: LoginComponent},
      {path: 'Register', component: RegisterComponent},
      {path: 'NewsFeed', component: NewsFeedComponent},
      {path: 'BlockedAccounts', component: BlockedAccountsComponent},
      {path: 'AccountUpdate', component: AccountUpdateComponent},
      {path: 'Search', component: SearchComponent},
      {path: 'Images', component: ImagesComponent},
      {path: 'Videos', component: VideosComponent}
       ]),
    HttpClientModule

],
  providers: [AuthService,UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
