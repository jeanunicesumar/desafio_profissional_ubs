import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Teste4Component } from './teste4.component';

describe('Teste4Component', () => {
  let component: Teste4Component;
  let fixture: ComponentFixture<Teste4Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Teste4Component]
    });
    fixture = TestBed.createComponent(Teste4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
