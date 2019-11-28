import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RhEditmodalComponent } from './rh-editmodal.component';

describe('RhEditmodalComponent', () => {
  let component: RhEditmodalComponent;
  let fixture: ComponentFixture<RhEditmodalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RhEditmodalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RhEditmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
