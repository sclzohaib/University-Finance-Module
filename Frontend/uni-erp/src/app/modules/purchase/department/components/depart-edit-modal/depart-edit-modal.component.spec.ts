import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartEditModalComponent } from './depart-edit-modal.component';

describe('DepartEditModalComponent', () => {
  let component: DepartEditModalComponent;
  let fixture: ComponentFixture<DepartEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepartEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
