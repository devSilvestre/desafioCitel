import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarUnidosComponent } from './navbar-unidos.component';

describe('NavbarUnidosComponent', () => {
  let component: NavbarUnidosComponent;
  let fixture: ComponentFixture<NavbarUnidosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarUnidosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarUnidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
