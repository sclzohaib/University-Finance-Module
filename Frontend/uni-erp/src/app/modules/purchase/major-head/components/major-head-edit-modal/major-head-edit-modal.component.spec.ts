import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MajorHeadEditModalComponent } from './major-head-edit-modal.component';

describe('MajorHeadEditModalComponent', () => {
  let component: MajorHeadEditModalComponent;
  let fixture: ComponentFixture<MajorHeadEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MajorHeadEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MajorHeadEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
