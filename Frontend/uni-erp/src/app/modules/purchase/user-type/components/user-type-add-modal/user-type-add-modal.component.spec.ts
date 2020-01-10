import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTypeAddModalComponent } from './user-type-add-modal.component';

describe('UserTypeAddModalComponent', () => {
  let component: UserTypeAddModalComponent;
  let fixture: ComponentFixture<UserTypeAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTypeAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTypeAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
