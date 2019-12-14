import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClAddmodalComponent } from './cl-addmodal.component';

describe('ClAddmodalComponent', () => {
  let component: ClAddmodalComponent;
  let fixture: ComponentFixture<ClAddmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClAddmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClAddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
