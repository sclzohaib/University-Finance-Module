import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinorHeadEditModalComponent } from './minor-head-edit-modal.component';

describe('MinorHeadEditModalComponent', () => {
  let component: MinorHeadEditModalComponent;
  let fixture: ComponentFixture<MinorHeadEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinorHeadEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinorHeadEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
