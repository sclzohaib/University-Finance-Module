import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GstComponent } from './gst.component';

describe('GstComponent', () => {
  let component: GstComponent;
  let fixture: ComponentFixture<GstComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GstComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GstComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
