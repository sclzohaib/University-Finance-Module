import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MajorHeadAddModalComponent } from './major-head-add-modal.component';

describe('MajorHeadAddModalComponent', () => {
  let component: MajorHeadAddModalComponent;
  let fixture: ComponentFixture<MajorHeadAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MajorHeadAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MajorHeadAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
