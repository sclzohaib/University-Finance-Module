import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationViewModalComponent } from './application-view-modal.component';

describe('ApplicationViewModalComponent', () => {
  let component: ApplicationViewModalComponent;
  let fixture: ComponentFixture<ApplicationViewModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicationViewModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationViewModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
