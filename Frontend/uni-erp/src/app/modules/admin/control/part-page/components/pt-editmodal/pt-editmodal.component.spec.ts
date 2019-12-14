import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PtEditmodalComponent } from './pt-editmodal.component';

describe('PtEditmodalComponent', () => {
  let component: PtEditmodalComponent;
  let fixture: ComponentFixture<PtEditmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PtEditmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PtEditmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
