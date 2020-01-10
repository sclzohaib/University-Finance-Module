import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GstEditModalComponent } from './gst-edit-modal.component';

describe('GstEditModalComponent', () => {
  let component: GstEditModalComponent;
  let fixture: ComponentFixture<GstEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GstEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GstEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
