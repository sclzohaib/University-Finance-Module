import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthSignAddModalComponent } from './auth-sign-add-modal.component';

describe('AuthSignAddModalComponent', () => {
  let component: AuthSignAddModalComponent;
  let fixture: ComponentFixture<AuthSignAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthSignAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthSignAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
