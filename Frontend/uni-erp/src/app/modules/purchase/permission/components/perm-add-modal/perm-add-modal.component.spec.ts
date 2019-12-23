import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PermAddModalComponent } from './perm-add-modal.component';

describe('PermAddModalComponent', () => {
  let component: PermAddModalComponent;
  let fixture: ComponentFixture<PermAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PermAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
