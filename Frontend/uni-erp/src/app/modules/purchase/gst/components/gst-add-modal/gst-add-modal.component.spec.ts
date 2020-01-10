import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GstAddModalComponent } from './gst-add-modal.component';

describe('GstAddModalComponent', () => {
  let component: GstAddModalComponent;
  let fixture: ComponentFixture<GstAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GstAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GstAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
