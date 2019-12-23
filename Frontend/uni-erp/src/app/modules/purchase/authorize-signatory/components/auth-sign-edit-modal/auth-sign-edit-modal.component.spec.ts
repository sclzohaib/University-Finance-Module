import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthSignEditModalComponent } from './auth-sign-edit-modal.component';

describe('AuthSignEditModalComponent', () => {
  let component: AuthSignEditModalComponent;
  let fixture: ComponentFixture<AuthSignEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthSignEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthSignEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
