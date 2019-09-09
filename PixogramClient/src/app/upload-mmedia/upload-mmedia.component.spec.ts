import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadMMediaComponent } from './upload-mmedia.component';

describe('UploadMMediaComponent', () => {
  let component: UploadMMediaComponent;
  let fixture: ComponentFixture<UploadMMediaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadMMediaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadMMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
