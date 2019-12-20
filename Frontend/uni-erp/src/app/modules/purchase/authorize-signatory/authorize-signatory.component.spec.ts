import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizeSignatoryComponent } from './authorize-signatory.component';

describe('AuthorizeSignatoryComponent', () => {
  let component: AuthorizeSignatoryComponent;
  let fixture: ComponentFixture<AuthorizeSignatoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizeSignatoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizeSignatoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
