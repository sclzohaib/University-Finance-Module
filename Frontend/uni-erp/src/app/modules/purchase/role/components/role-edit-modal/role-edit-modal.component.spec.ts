import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleEditModalComponent } from './role-edit-modal.component';

describe('RoleEditModalComponent', () => {
  let component: RoleEditModalComponent;
  let fixture: ComponentFixture<RoleEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoleEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoleEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
