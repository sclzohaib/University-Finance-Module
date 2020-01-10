import { GstService } from './../../../../../core/services/Purchase/gst.service';
import { Component, OnInit } from '@angular/core';
import { Gst } from 'src/app/core/models/Purchase/gst';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-gst-add-modal',
  templateUrl: './gst-add-modal.component.html',
  styleUrls: ['./gst-add-modal.component.less']
})
export class GstAddModalComponent implements OnInit {

	gst: Gst = new Gst();
  constructor(private gstService: GstService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	saveGst(){
		// console.log(this.authLvl);
		this.gstService.saveGst(this.gst).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `GST Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Level Successfully Added!`);
				this.message.create('error', `GST Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

}
