import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrnEditModalComponent } from './grn-edit-modal.component';

describe('GrnEditModalComponent', () => {
  let component: GrnEditModalComponent;
  let fixture: ComponentFixture<GrnEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrnEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrnEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
