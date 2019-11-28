import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RhAddmodalComponent } from './rh-addmodal.component';

describe('RhAddmodalComponent', () => {
  let component: RhAddmodalComponent;
  let fixture: ComponentFixture<RhAddmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RhAddmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RhAddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
