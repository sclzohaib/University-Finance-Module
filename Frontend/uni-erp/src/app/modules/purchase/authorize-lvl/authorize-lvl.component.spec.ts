import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizeLvlComponent } from './authorize-lvl.component';

describe('AuthorizeLvlComponent', () => {
  let component: AuthorizeLvlComponent;
  let fixture: ComponentFixture<AuthorizeLvlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizeLvlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizeLvlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
