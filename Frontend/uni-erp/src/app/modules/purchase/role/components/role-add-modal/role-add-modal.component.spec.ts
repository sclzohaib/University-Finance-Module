import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleAddModalComponent } from './role-add-modal.component';

describe('RoleAddModalComponent', () => {
  let component: RoleAddModalComponent;
  let fixture: ComponentFixture<RoleAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoleAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoleAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
