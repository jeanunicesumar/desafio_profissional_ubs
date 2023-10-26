import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgendamentoItemComponent } from './agendamento-item.component';

describe('AgendamentoItemComponent', () => {
  let component: AgendamentoItemComponent;
  let fixture: ComponentFixture<AgendamentoItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgendamentoItemComponent]
    });
    fixture = TestBed.createComponent(AgendamentoItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
