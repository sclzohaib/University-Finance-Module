import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StdAddmodalComponent } from './std-addmodal.component';

describe('StdAddmodalComponent', () => {
  let component: StdAddmodalComponent;
  let fixture: ComponentFixture<StdAddmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StdAddmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StdAddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
