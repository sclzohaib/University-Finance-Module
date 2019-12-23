import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UniAddModalComponent } from './uni-add-modal.component';

describe('UniAddModalComponent', () => {
  let component: UniAddModalComponent;
  let fixture: ComponentFixture<UniAddModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UniAddModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UniAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
