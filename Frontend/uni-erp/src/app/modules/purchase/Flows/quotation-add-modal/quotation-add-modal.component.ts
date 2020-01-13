import { Component, OnInit, ViewChild, ElementRef, HostListener } from '@angular/core';
import { NzInputDirective } from 'ng-zorro-antd';

interface ItemData {
  id: string;
  name: string;
  age: string;
  address: string;
}
@Component({
  selector: 'app-quotation-add-modal',
  templateUrl: './quotation-add-modal.component.html',
  styleUrls: ['./quotation-add-modal.component.less']
})
export class QuotationAddModalComponent implements OnInit {

  constructor() { }

  i = 1;
  editId: string | null;
  listOfData: ItemData[] = [];
  @ViewChild(NzInputDirective, { static: false, read: ElementRef }) inputElement: ElementRef;

  @HostListener('window:click', ['$event'])
  handleClick(e: MouseEvent): void {
    if (this.editId && this.inputElement && this.inputElement.nativeElement !== e.target) {
      this.editId = null;
    }
  }

  addRow(): void {
    this.listOfData = [
      ...this.listOfData,
      {
        id: `${this.i}`,
        name: `Edward King ${this.i}`,
        age: '32',
        address: `London, Park Lane no. ${this.i}`
      }
    ];
    this.i++;
  }

  deleteRow(id: string): void {
    this.listOfData = this.listOfData.filter(d => d.id !== id);
  }

  startEdit(id: string, event: MouseEvent): void {
    event.preventDefault();
    event.stopPropagation();
    this.editId = id;
  }

  ngOnInit(): void {
    // this.addRow();
    // this.addRow();
  }
}


