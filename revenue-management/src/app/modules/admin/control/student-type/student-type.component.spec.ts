import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentTypeComponent } from './student-type.component';

describe('StudentTypeComponent', () => {
  let component: StudentTypeComponent;
  let fixture: ComponentFixture<StudentTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
