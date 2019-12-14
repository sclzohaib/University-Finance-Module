import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClEditmodalComponent } from './cl-editmodal.component';

describe('ClEditmodalComponent', () => {
  let component: ClEditmodalComponent;
  let fixture: ComponentFixture<ClEditmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClEditmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClEditmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
