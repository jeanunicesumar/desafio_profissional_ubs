import { Directive, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: 'textarea[textareaAutoresize]'
})
export class TextareaAutoresizeDirective {

  constructor(private el: ElementRef, private renderer: Renderer2) { }

  @HostListener('input', ['$event.target'])
  onInput(textArea: HTMLTextAreaElement): void {
    this.adjustTextAreaHeight(textArea);
  }

  ngAfterViewInit() {
    setTimeout(() => {
      this.adjustTextAreaHeight(this.el.nativeElement);
    }, 0);
  }

  private adjustTextAreaHeight(textArea: HTMLTextAreaElement): void {
    textArea.style.overflow = 'hidden';
    textArea.style.height = 'auto';
    textArea.style.height = textArea.scrollHeight + 'px';
  }
}

