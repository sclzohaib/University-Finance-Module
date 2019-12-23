import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PermEditModalComponent } from './perm-edit-modal.component';

describe('PermEditModalComponent', () => {
  let component: PermEditModalComponent;
  let fixture: ComponentFixture<PermEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PermEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
