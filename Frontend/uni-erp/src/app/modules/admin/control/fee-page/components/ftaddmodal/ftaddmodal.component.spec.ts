import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FtaddmodalComponent } from './ftaddmodal.component';

describe('FtaddmodalComponent', () => {
  let component: FtaddmodalComponent;
  let fixture: ComponentFixture<FtaddmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FtaddmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FtaddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
