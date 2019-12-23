import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartAddModalComponent } from './depart-add-modal.component';

describe('DepartAddModalComponent', () => {
  let component: DepartAddModalComponent;
  let fixture: ComponentFixture<DepartAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepartAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
