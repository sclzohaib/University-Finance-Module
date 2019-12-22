import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthLvlEditModalComponent } from './auth-lvl-edit-modal.component';

describe('AuthLvlEditModalComponent', () => {
  let component: AuthLvlEditModalComponent;
  let fixture: ComponentFixture<AuthLvlEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthLvlEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthLvlEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
