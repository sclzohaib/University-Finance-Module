import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationAddModalComponent } from './application-add-modal.component';

describe('ApplicationAddModalComponent', () => {
  let component: ApplicationAddModalComponent;
  let fixture: ComponentFixture<ApplicationAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicationAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
