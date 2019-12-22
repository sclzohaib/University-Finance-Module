import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthLvlAddModalComponent } from './auth-lvl-add-modal.component';

describe('AuthLvlAddModalComponent', () => {
  let component: AuthLvlAddModalComponent;
  let fixture: ComponentFixture<AuthLvlAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthLvlAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthLvlAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
