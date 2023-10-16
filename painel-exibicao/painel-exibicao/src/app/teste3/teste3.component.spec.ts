import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Teste3Component } from './teste3.component';

describe('Teste3Component', () => {
  let component: Teste3Component;
  let fixture: ComponentFixture<Teste3Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Teste3Component]
    });
    fixture = TestBed.createComponent(Teste3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
