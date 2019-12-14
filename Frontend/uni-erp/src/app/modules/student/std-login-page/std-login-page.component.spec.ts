import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StdLoginPageComponent } from './std-login-page.component';

describe('StdLoginPageComponent', () => {
  let component: StdLoginPageComponent;
  let fixture: ComponentFixture<StdLoginPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StdLoginPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StdLoginPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
