import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueHeadComponent } from './revenue-head.component';

describe('RevenueHeadComponent', () => {
  let component: RevenueHeadComponent;
  let fixture: ComponentFixture<RevenueHeadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevenueHeadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevenueHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
