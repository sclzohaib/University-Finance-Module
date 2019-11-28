import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PtAddmodalComponent } from './pt-addmodal.component';

describe('PtAddmodalComponent', () => {
  let component: PtAddmodalComponent;
  let fixture: ComponentFixture<PtAddmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PtAddmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PtAddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
