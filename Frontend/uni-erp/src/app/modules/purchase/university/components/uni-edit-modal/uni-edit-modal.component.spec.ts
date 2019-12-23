import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UniEditModalComponent } from './uni-edit-modal.component';

describe('UniEditModalComponent', () => {
  let component: UniEditModalComponent;
  let fixture: ComponentFixture<UniEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UniEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UniEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
