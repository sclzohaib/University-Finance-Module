import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MinorHeadComponent } from './minor-head.component';

describe('MinorHeadComponent', () => {
  let component: MinorHeadComponent;
  let fixture: ComponentFixture<MinorHeadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MinorHeadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MinorHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
