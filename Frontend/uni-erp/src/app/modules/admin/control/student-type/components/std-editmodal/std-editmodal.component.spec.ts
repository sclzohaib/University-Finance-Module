import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StdEditmodalComponent } from './std-editmodal.component';

describe('StdEditmodalComponent', () => {
  let component: StdEditmodalComponent;
  let fixture: ComponentFixture<StdEditmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StdEditmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StdEditmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
