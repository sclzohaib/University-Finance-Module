import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTypeEditModalComponent } from './user-type-edit-modal.component';

describe('UserTypeEditModalComponent', () => {
  let component: UserTypeEditModalComponent;
  let fixture: ComponentFixture<UserTypeEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTypeEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTypeEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
