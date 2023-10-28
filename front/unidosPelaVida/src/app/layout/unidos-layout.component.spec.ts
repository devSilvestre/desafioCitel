import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidosLayoutComponent } from './unidos-layout.component';

describe('UnidosLayoutComponent', () => {
  let component: UnidosLayoutComponent;
  let fixture: ComponentFixture<UnidosLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnidosLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnidosLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
